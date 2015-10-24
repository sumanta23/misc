package org.sumanta.field;
import java.util.Date;



public class TheClass {
	
	@Id
	public int primaryKey;
	@Id @Column
	public String name;
	
	public int getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
