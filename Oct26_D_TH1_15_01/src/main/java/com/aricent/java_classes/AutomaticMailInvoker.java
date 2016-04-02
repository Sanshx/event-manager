/***********************************************************************
                         Aricent Technologies Proprietary





This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies

	  File Name	            	: AutomaticMailInvoker.java
	  Principal Author      	: Sanchit Saxena gur43194
	  Subsystem Name        	:
	  Module Name           	:
	  Date of First Release 	: Jan 5, 2016
	  Author					: gur43194
	  Description           	: This file contains Automatic invoker class
	  							  which runs the Automatic mailing system at
	  							  a fixed amount of time.


	  Change History

	  Version      				:
	  Date(DD/MM/YYYY) 			:
	  Modified by				:
	  Description of change 	:

 ***********************************************************************/
package com.aricent.java_classes;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.aricent.database_queries.MailingSystemQueries;
import com.aricent.pojo_classes.DatabaseNameHolder;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author gur43194 This class invokes the mailing system after a fixed amount
 *         of time Before starting the mail invoker, it also checks for any
 *         pre_existing pending mails due to some server shutdown, after sending
 *         those mails, it continues with the normal function of invoking
 *         mailing system at a fixed amount of time.
 */
public class AutomaticMailInvoker implements ServletContextListener {

	private ScheduledExecutorService scheduler;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent) This function will run of server server shutdown
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		scheduler.shutdownNow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent) This function will run of server startup.
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// Releasing a thread for checking any pending mails
		Thread check = new Thread(new Runnable() {

			@Override
			public void run() {
				ArrayList<DatabaseNameHolder> allDatabaseList = MailingSystemQueries
						.getAllDatabasesList();
				for (DatabaseNameHolder databaseName : allDatabaseList) {
					// Releasing thread for completion of pending mails
					MailListCreator.threadCreation(databaseName.getOrgDbName());
				}
			}
		});
		check.start();

		// Waiting for previous pending mails to complete
		try {
			check.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Invoking mailing system at regular intervals
		scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				// Releasing thread for mailing
				new LocationTimeChecker().findWishLocations();
			}
		}, 0, 5, TimeUnit.HOURS);
	}

}
