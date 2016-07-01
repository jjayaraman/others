package com.jai.msoutlook;

import com.moyosoft.exchange.Exchange;
import com.moyosoft.exchange.ExchangeServiceException;
import com.moyosoft.exchange.folder.ExchangeFolder;
import com.moyosoft.exchange.folder.FoldersCollection;
import com.moyosoft.exchange.folder.FoldersIterator;
import com.moyosoft.exchange.item.ExchangeItem;
import com.moyosoft.exchange.item.ItemsCollection;
import com.moyosoft.exchange.item.ItemsIterator;

/**
 *
 */
public class Moyosoft {

	Exchange exchange;

	public Moyosoft() {
		try {
			exchange = new Exchange("casarray2.ebauk.local", "jjayaraman", "ebaAdmin15");
		} catch (ExchangeServiceException e) {
			e.printStackTrace();
		}
	}

	public void getFolders() {

		try {

			FoldersCollection foldersCollection = exchange.getTopFolders();
			FoldersIterator foldersIterator = foldersCollection.iterator();

			String id = null;
			while (foldersIterator.hasNext()) {

				ExchangeFolder exchangeFolder = foldersIterator.nextFolder();

				id = exchangeFolder.getFolderId();
				System.out.println(exchangeFolder.getFolderId() + " - " + exchangeFolder);

			}

			System.out.println(foldersCollection.getCount());
			System.out.println("id : " + id + " : " + foldersCollection.get(id));

		} catch (ExchangeServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void one() {
		try {

			ExchangeFolder exchangeFolder = exchange.getInboxFolder();

			System.out.println(exchangeFolder);

			ItemsCollection itemsCollection = exchangeFolder.getItems();

			ItemsIterator itemsIterator = itemsCollection.iterator();

			while (itemsIterator.hasNext()) {
				ExchangeItem exchangeItem = itemsIterator.nextItem();
				System.out.println(exchangeItem.getBodyAsText());
			}

		} catch (ExchangeServiceException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		Moyosoft moyosoft = new Moyosoft();
		moyosoft.getFolders();
		// moyosoft.one();;
	}
}
