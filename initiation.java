import java.util.*;
import java.sql.*;
import java.lang.reflect.*;
import java.lang.*;
//Please read comments carefully
//Read comment at the END to see an example

public class initiation<T>{
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    
//////////////////////////////////setting up connection //////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////
    public void connect(String DatabaseName, String HostName, String Password) throws Exception {

        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Setup the connection with the DB
        setConnection(DriverManager.getConnection("jdbc:mysql://localhost/"+DatabaseName+"",""+HostName+"",""+Password+""));

}

    ////////////////////////////////////// SETS AND GETS ///////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    public Connection getConnection(){
        return connection;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    public void setStatement(Statement statement){
        this.statement = statement;
    }
    public Statement getStatement(){
        return statement;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    public void setResultSet(ResultSet resultSet){
        this.resultSet = resultSet;
    }
    public ResultSet getResultSet(){
        return resultSet;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    public <T> ArrayList<T> Init_obj(String cin, String Table) throws Exception{
        return init_obj(cin, Table);
    }
    ////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////// INITIATE OBJECT /////////////////////////////////////////////
//  @SuppressWarnings("unchecked")
    //ciq = class in question
    // table name from database
    
    public <T> ArrayList<T> init_obj(String ciq, String Table) throws Exception{

        //forName() = LoadClass
        //Basically loads the class that is passed in the parameter as a string
        // example class is faculty
        // forName("faculty")
        // sometimes it needs a package connection
        
        // "?" is a higher form of generalization
        // Basically includes both <T> and <E>
    	//PurchaseReq is the name of the package!
        Class<?> c = Class.forName(ciq);
        
        //this is called the reflecter
        //basically accesses the needed constructor
        //that is residing inside the passed class
        //Any parametes needed should have .class extension
        //example c.getConstructor(int.class,String.class,etc)
        
        Constructor<?> constr = c.getConstructor(ArrayList.class);

        setStatement( getConnection().createStatement() );
        setResultSet( getStatement().executeQuery("select * from " + Table) );

        
        ArrayList<String> data = new ArrayList<>();
        ResultSetMetaData count = getResultSet().getMetaData();
        int ColmnNo = count.getColumnCount();
        ArrayList<T> objects = new ArrayList<>();

        while(getResultSet().next()){
            //The bound of getString is the number of Columns
            for(int i = 1; i <= ColmnNo; i++)
                data.add(getResultSet().getString(i));

            //const.newInstance(data)
            objects.add((T)constr.newInstance(data));
            data.clear();
        }

        return objects;

    }
    
    

    

}


//initiation<PR> initiate = new initiation();
//ArrayList<PR> prList = new ArrayList();
//try {
//	initiate.connect("purchasereq?useSSL=false", "root", "1234");
//} catch (Exception ex) {
//	System.out.println(ex); 
//}
// 
//try {
//	
//	pr = in0.Init_obj("PR", "pr");
//    
//}catch (Exception ex) {
//	System.out.println(ex); 
//}


