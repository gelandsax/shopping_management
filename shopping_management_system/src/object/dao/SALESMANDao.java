package object.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import object.db.Dbconnection;
import object.db.Dbclose;
import object.entity.SALESMAN;

/**
 * 数据库SalesMan表操作
 */
public final class SALESMANDao {
    Connection        conn  = null;
    PreparedStatement pstmt = null;
    ResultSet 		rs 	 	 = null;
    /**
     * 1.前台收银登陆
     * @param sname 用户名
     * @return ArrayList<SALESMAN> spassword,sid
     */
    public ArrayList<SALESMAN> checkstandLog(String sname) {
        ArrayList<SALESMAN> salesManInfo = new ArrayList<SALESMAN>();
        conn = Dbconnection.getconnection();
        String sql = "SELECT SID,SPASSWORD FROM SALESMAN WHERE SNAME=?";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,sname);

            rs 	  = pstmt.executeQuery();
            while (rs.next())
            {
                String spassword = rs.getString("spassword");
                int sid = rs.getInt("sid");
                SALESMAN salesMan = new SALESMAN(sid,spassword);
                salesManInfo.add(salesMan);
            }
        } catch (SQLException e1)
        {
            e1.printStackTrace();
        }finally
        {
            Dbclose.queryClose(pstmt, rs, conn);
        }
        return salesManInfo;
    }

    /**
     * 2.添加售货员
     * @param sname 用户名
     * @return boolean
     */
    public boolean addSALESMAN(SALESMAN sname) {
        boolean bool = false;
        conn = Dbconnection.getconnection();
        String sql = "INSERT INTO SALESMAN(SNAME,SPASSWORD) VALUES(?,?)";

        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,sname.getSname());
            pstmt.setString(2,sname.getSPassWord());

            int rs = pstmt.executeUpdate();
            if (rs > 0)
            {
                bool = true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            Dbclose.addClose(pstmt,conn);
        }
        return bool;
    }

    /**
     * 3.更改售货员信息
     * @param key 	要更改项
     * @param sname 用户名
     * @return boolean
     */
    public  boolean updateSALESMAN(int key,SALESMAN sname) {

        boolean bool = false;
        conn = Dbconnection.getconnection();
        switch (key)
        {
            case 1:		//	3.1 更改售货员姓名
                String sqlName = "UPDATE SALESMAN SET SNAME=? WHERE SID=?";

                try
                {
                    pstmt = conn.prepareStatement(sqlName);
                    pstmt.setString(1, sname.getSname());
                    pstmt.setInt(2,sname.getSid());

                    int rs = pstmt.executeUpdate();
                    if (rs > 0)
                    {
                        bool = true;
                    }
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }finally{
                    Dbclose.addClose(pstmt,conn);
                }
                break;
            case 2:		//	3.2 更改售货员密码
                String sqlPrice = "UPDATE SALESMAN SET SPASSWORD=? WHERE SID=?";

                try
                {
                    pstmt = conn.prepareStatement(sqlPrice);
                    pstmt.setString(1,sname.getSPassWord());
                    pstmt.setInt(2, sname.getSid());

                    int rs = pstmt.executeUpdate();
                    if (rs > 0)
                    {
                        bool = true;
                    }
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }finally{
                    Dbclose.addClose(pstmt,conn);
                }
                break;
            default:
                break;
        }
        return bool;
    }

    /**
     * 4.删除售货员
     * @param sname 用户名
     * @return boolean
     */
    public boolean deleteSALESMAN(String sname)
    {
        boolean bool = false;
        conn = Dbconnection.getconnection();
        String sql = "DELETE FROM SALESMAN WHERE SNAME=?";
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,sname);
            int rs = pstmt.executeUpdate();
            if (rs > 0)
            {
                bool = true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            Dbclose.addClose(pstmt,conn);
        }
        return bool;
    }

    /**
     * 5.模糊查询售货员
     * @param sname 用户名
     * @return ArrayList<SalesMan>
     */
    public ArrayList<SALESMAN> querySALESMAN(String sname)
    {
        ArrayList<SALESMAN> SalesManList = new ArrayList<SALESMAN>();
        conn = Dbconnection.getconnection();

        sname = "%"+sname+"%";	//从用户处获取的字符串加上 % 符号，来达到模糊查询的目的.
        String sql = "SELECT * FROM SALESMAN WHERE SNAME LIKE ?";  //居然不能直接跟 % .只能用连接字符串的方式
        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sname);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                int sid = rs.getInt("sid");
                String sName = rs.getString(2);
                String sPassWord = rs.getString(3);

                SALESMAN salesMan = new SALESMAN(sid,sName,sPassWord);
                SalesManList.add(salesMan);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            Dbclose.queryClose(pstmt, rs, conn);
        }
        return SalesManList;
    }

    /**
     * 6.显示所有售货员
     * @return ArrayList<SalesMan>
     */
    public  ArrayList<SALESMAN> displaySALESMAN() {
        ArrayList<SALESMAN> salesManList = new ArrayList<SALESMAN>();
        conn = Dbconnection.getconnection();
        String sql = "SELECT * FROM SALESMAN";

        try
        {
            pstmt = conn.prepareStatement(sql);
            rs =  pstmt.executeQuery();
            while (rs.next())
            {
                int sid = rs.getInt(1);
                String sname = rs.getString(2);
                String spassword = rs.getString(3);

                SALESMAN salesMan = new SALESMAN(sid,sname,spassword);
                salesManList.add(salesMan);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            Dbclose.queryClose(pstmt, rs, conn);
        }
        return salesManList;
    }
}
