package com.cgs.db.meta.retriever;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.cgs.db.exception.DatabaseMetaGetMetaException;
import com.cgs.db.meta.core.SchemaInfoLevel;
import com.cgs.db.meta.schema.Constraint;
import com.cgs.db.meta.schema.Function;
import com.cgs.db.meta.schema.Procedure;
import com.cgs.db.meta.schema.SchemaInfo;
import com.cgs.db.meta.schema.Table;
import com.cgs.db.meta.schema.Trigger;

public class PostgreSQLMetaCrawler extends AbstractMetaCrawler {
	
	public PostgreSQLMetaCrawler() {
		super();
	}
	
	public PostgreSQLMetaCrawler(DatabaseMetaData databaseMetaData) {
		super(databaseMetaData);
	}
	
	public Set<SchemaInfo> getSchemaInfos() {
		Set<SchemaInfo> schemaInfos = new HashSet<SchemaInfo>();
		try {
			ResultSet rs = dbm.getCatalogs();
			while (rs.next()) {
				String catalogName = rs.getString("TABLE_CAT");
				SchemaInfo schemaInfo = new SchemaInfo(catalogName, null);
				schemaInfos.add(schemaInfo);
			}
		} catch (SQLException e) {
			throw new DatabaseMetaGetMetaException("Get database(PostgreSQL) schema information error!", e);
		}
		return schemaInfos;
	}

	public Procedure getProcedure(String procedureName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Procedure> getProcedures() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getTriggerNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Trigger getTrigger(String triggerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Trigger> getTriggers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getFunctionNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Function getFunction(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Function> getFunctions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Table invokeCrawlTableInfo(String tableName, SchemaInfoLevel level) {
		return crawlTableInfo(null, null, tableName, level);
	}

	@Override
	protected Map<String, Constraint> crawlConstraint(String tableName,
			SchemaInfo schemaInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Map<String, Trigger> crawleTriggers(String tableName,
			SchemaInfo schemaInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
