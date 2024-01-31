package object.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import object.db.Dbconnection;
import object.db.Dbclose;
import object.entity.GSALES;

/**
 * 数据库gSales表操作
 */
public class GSALESDao {
    Connection        conn  = null;
    PreparedStatement pstmt = null;
    ResultSet 		  rs    = null;

    /**
     * 1.当天卖出的商品
     * @return ArrayList<Gsales> 商品信息,包括 allSum (单种商品的销售总和)
     */
    public ArrayList<GSALES> dailyGSALES() {
        ArrayList<GSALES> GsalesList = new ArrayList<GSALES>();
        conn = Dbconnection.getconnection();

        //售卖时间=当前时间 trunc(sdate) =trunc(sysdate) 单位：天
        String sql = "select gname,gprice,gnum, allSum from goods, (select gid as salesid,sum(snum) as allSum from gsales where trunc(sdate) =trunc(sysdate) group by gid) where gid = salesid";
        try
        {
            pstmt = conn.prepareStatement(sql);
            rs 	  = pstmt.executeQuery();
            while (rs.next())
            {
                String gname = rs.getString(1);
                double gprice = rs.getDouble(2);
                int gnum = rs.getInt(3);
                int allSnum = rs.getInt("allSum");

                GSALES Gsales = new GSALES(gname,gprice,gnum,allSnum);
                GsalesList.add(Gsales);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally
        {
            Dbclose.queryClose(pstmt,rs,conn);
        }
        return GsalesList;
    }

    /**
     *2.购物结算-向sales表中插入商品数据！
     *@param gSales 售卖商品对象
     *@return boolean
     */
    public boolean shoppingSettlement(GSALES gSales) {
        boolean bool = false;
        conn = Dbconnection.getconnection();
        String sql = "INSERT INTO GSALES(GID,SID,SNUM) VALUES(?,?,?)";

        try
        {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,gSales.getGid());
            pstmt.setInt(2,gSales.getSid());
            pstmt.setInt(3,gSales.getSnum());

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
}
