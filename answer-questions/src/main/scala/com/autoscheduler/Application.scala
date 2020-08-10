package com.autoscheduler

import java.sql.{ DriverManager, ResultSet }

import scala.annotation.tailrec

object Application extends App {
  val driver = "org.sqlite.JDBC"
  val url = "jdbc:sqlite:file:../global-marketing-worldbank-report/autoscheduler.db?cache=shared"
  val username = "admin"
  val password = "admin"
  
  @tailrec
  def printFirstQuestion( rs: ResultSet ): Unit = {
    if ( rs.next() ) {
      val country = rs.getString( "country_value" )
      val averageGDP = rs.getDouble( "average_gdp" )
      println( String.format( "%-20s ===> %10s", s"$country", s"$averageGDP" ) )
      printFirstQuestion( rs )
    }
  }
  try {
    Class.forName( driver )
    val connection = DriverManager.getConnection( url, username, password )
    
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(
      "SELECT " +
          "country_value, value, AVG(value) " +
          "AS " +
          "average_gdp " +
          "FROM " +
          "information " +
          "GROUP BY " +
          "countryiso3code " +
          "ORDER BY " +
          "average_gdp DESC " +
          "LIMIT 10 " )
    print( "+" )
    println( s"${1.to( 28 ).foreach( line => print( "-" ) )}+" )
    
    println( String.format( "|%-20s ===> %10s|", "Country", "Average GDP ( Gross Domestic Product)" ) + "\n" )
    printFirstQuestion( resultSet )
    connection.close()
    
  } catch {
    case e: Exception => e.printStackTrace()
  }
  
}