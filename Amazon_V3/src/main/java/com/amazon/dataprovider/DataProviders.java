/**
 * 
 */
package com.amazon.dataprovider;

import org.testng.annotations.DataProvider;

import com.amazon.utility.NewExcelLibrary;

/**
 * @author Dinesh
 *
 */
public class DataProviders {
	
	NewExcelLibrary obj=new NewExcelLibrary();
	
	@DataProvider(name="AmazonLoginData")
	public Object[][] getAmazonLogindata(){
		int rows=obj.getRowCount("Sheet1");
		int columns=obj.getColumnCount("Sheet1");
		int actrows=rows-1;
		Object[][] data=new Object[actrows][columns];
		for(int i=0; i<actrows; i++) {
			for(int j=0; j<columns; j++) {
				data[i][j]=obj.getCellData("Sheet1", j, i+2);
			}
		}
		return data;
	}
	
	
	@DataProvider(name="ProductName")
	public Object[][]getProductName(){
		int rows=obj.getRowCount("Sheet2");
		int columns=obj.getColumnCount("Sheet2");
		int actrows=rows-1;
		Object[][] data=new Object[rows][columns];
		for(int i=0; i<actrows; i++) {
			for(int j=0; j<columns; j++) {
				data[i][j]=obj.getCellData("Sheet2", j, i+2);
			}
		}
		return data;
	}
	

}
