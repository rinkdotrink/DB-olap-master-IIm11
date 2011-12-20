package de.datagenerator.dbwriter;

import de.datagenerator.datamodel.FactoryMethodProduct;

public abstract class DBWriter {

	public abstract void write(FactoryMethodProduct factMethProd);
	public abstract void close();
	
}
