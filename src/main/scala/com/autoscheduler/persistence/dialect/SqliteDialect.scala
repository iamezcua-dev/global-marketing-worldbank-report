package com.autoscheduler.persistence.dialect

import java.sql.Types

import org.hibernate.`type`.StringType
import org.hibernate.dialect.Dialect
import org.hibernate.dialect.function.{ SQLFunctionTemplate, StandardSQLFunction, VarArgsSQLFunction }

case class SqliteDialect( ) extends Dialect {
  registerColumnType( Types.BIT, "integer" )
  registerColumnType( Types.TINYINT, "tinyint" )
  registerColumnType( Types.SMALLINT, "smallint" )
  registerColumnType( Types.INTEGER, "integer" )
  registerColumnType( Types.BIGINT, "bigint" )
  registerColumnType( Types.FLOAT, "float" )
  registerColumnType( Types.REAL, "real" )
  registerColumnType( Types.DOUBLE, "double" )
  registerColumnType( Types.NUMERIC, "numeric" )
  registerColumnType( Types.DECIMAL, "decimal" )
  registerColumnType( Types.CHAR, "char" )
  registerColumnType( Types.VARCHAR, "varchar" )
  registerColumnType( Types.LONGVARCHAR, "longvarchar" )
  registerColumnType( Types.DATE, "date" )
  registerColumnType( Types.TIME, "time" )
  registerColumnType( Types.TIMESTAMP, "timestamp" )
  registerColumnType( Types.BINARY, "blob" )
  registerColumnType( Types.VARBINARY, "blob" )
  registerColumnType( Types.LONGVARBINARY, "blob" )
  // registerColumnType(Types.NULL, "null");
  registerColumnType( Types.BLOB, "blob" )
  registerColumnType( Types.CLOB, "clob" )
  registerColumnType( Types.BOOLEAN, "integer" )
  
  registerFunction( "concat", new VarArgsSQLFunction( StringType.INSTANCE, "", "||", "" ) )
  registerFunction( "mod", new SQLFunctionTemplate( StringType.INSTANCE, "?1 % ?2" ) )
  registerFunction( "substr", new StandardSQLFunction( "substr", StringType.INSTANCE ) )
  registerFunction( "substring", new StandardSQLFunction( "substr", StringType.INSTANCE ) )
  
  override def supportsIdentityColumns = true
  
  // As specify in NHibernate dialect
  override def hasDataTypeInIdentityColumn = false
  
  // return "integer primary key autoincrement"
  override def getIdentityColumnString: String = "integer"
  
  override def getIdentitySelectString = "select last_insert_rowid()"
  
  override def supportsLimit = true
  
  override protected def getLimitString( query: String, hasOffset: Boolean ): String =
    new StringBuilder( query.length + 20 )
        .append( query )
        .append(
          if ( hasOffset ) " limit ? offset ?" else " limit ?" ).toString
  
  def supportsTemporaryTables = true
  
  def getCreateTemporaryTableString = "create temporary table if not exists"
  
  def dropTemporaryTableAfterUse = false
  
  override def supportsCurrentTimestampSelection = true
  
  override def isCurrentTimestampSelectStringCallable = false
  
  override def getCurrentTimestampSelectString = "select current_timestamp"
  
  override def supportsUnionAll = true
  
  override def hasAlterTable = false
  
  override def dropConstraints = false
  
  override def getAddColumnString = "add column"
  
  override def getForUpdateString = ""
  
  override def supportsOuterJoinForUpdate = false
  
  override def getDropForeignKeyString = throw new UnsupportedOperationException( "No drop foreign key syntax supported by SQLiteDialect" )
  
  override def getAddForeignKeyConstraintString( constraintName: String, foreignKey: Array[ String ], referencedTable: String, primaryKey: Array[ String ], referencesPrimaryKey: Boolean ) = throw new UnsupportedOperationException( "No add foreign key syntax supported by SQLiteDialect" )
  
  override def getAddPrimaryKeyConstraintString( constraintName: String ) = throw new UnsupportedOperationException( "No add primary key syntax supported by SQLiteDialect" )
  
  override def supportsIfExistsBeforeTableName = true
  
  override def supportsCascadeDelete = false
}
