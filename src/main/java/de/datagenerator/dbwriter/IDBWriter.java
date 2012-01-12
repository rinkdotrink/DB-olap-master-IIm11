package de.datagenerator.dbwriter;

import de.datagenerator.datamodel.Product;


public interface IDBWriter {

   public void close();
   
   public void write(final Product aProduct);
}
