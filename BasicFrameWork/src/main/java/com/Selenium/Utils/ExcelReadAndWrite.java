package com.Selenium.Utils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReadAndWrite {
	 Fillo fillo ;
	  static   Recordset recordset ;
	    static Connection connection ;
	    static String excelFilePath = System.getProperty("user.dir")+"\\DataFolder\\TestingData.xlsx";
	    static String sheetName = "Excel";
	    static String Column="FasTag";

	    public static Recordset data;

	    
	    
	    public static Recordset ReadExcelData(String FilePath , String sheetName , String ColumnName) {
	        try {
	            Fillo fillo = new Fillo();
	            connection = fillo.getConnection(FilePath);
	            String query = "SELECT * FROM " + sheetName + " WHERE TestCase='" + ColumnName + "'";
	            recordset = connection.executeQuery(query);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return recordset;
	    }

	   
	  
	    public void SelectQuery() throws FilloException {
	            try {
	                fillo = new Fillo();
	                connection = fillo.getConnection(excelFilePath);
	                String query = "SELECT * FROM " + sheetName + "";
	                recordset = connection.executeQuery(query);
	                while (recordset.next()) {
	                    for (String field : recordset.getFieldNames()) {
	                        System.out.print(field + ": " + recordset.getField(field) + ", ");
	                        System.out.println("--------");
	                    }

	                }
	            }catch (Exception e){
	                e.printStackTrace();
	            }
	            recordset.close();
	            connection.close();
	    }

	    
	    public void SelectQueryUsingLikeOperator() throws FilloException {
	        try {
	            fillo = new Fillo();
	            connection = fillo.getConnection(excelFilePath);
	            String query = "SELECT * FROM " + sheetName + " WHERE Name like 'ind%'";
	            recordset = connection.executeQuery(query);
	            while (recordset.next()) {
	                for (String field : recordset.getFieldNames()) {
	                    System.out.print(field + ": " + recordset.getField(field) + ", ");
	                    System.out.println("--------");
	                }

	            }
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        recordset.close();
	        connection.close();
	    }
	    @Test
	    public void UpdateQuery() throws FilloException {
	        try {
	            fillo = new Fillo();
	            connection = fillo.getConnection(excelFilePath);
	            String query = "UPDATE " + sheetName + " Set TestCase='Mahindra' WHERE UserName='2'";
	            connection.executeUpdate(query);

	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        recordset.close();
	        connection.close();
	    }

	    @Test
	    public void InsertQuery() throws FilloException {
	        try {
	            fillo = new Fillo();
	            connection = fillo.getConnection(excelFilePath);
	            String query = "INSERT INTO " + sheetName + " (UserName,Password) VALUES ('MotorVehicles','2023')";
	            connection.executeUpdate(query);

	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        recordset.close();
	        connection.close();
	    }

	    @Test
	    public void DeleteQuery() throws FilloException {
	        try {
	            fillo = new Fillo();
	            connection = fillo.getConnection(excelFilePath);
	            String query = "DELETE FROM " + sheetName + " WHERE TestCase='Eg'";
	            connection.executeUpdate(query);

	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        recordset.close();
	        connection.close();
	    }




	    @AfterTest
	    public void AfterTest(){
	        recordset.close();
	        connection.close();
	    }


}
