package object.entity;

//购物结算实体类
public final class GSALES {
    private int gid;
    private int sid;
    private int snum;

    private String gname;
    private double gprice;
    private int gnum;
    private int allSnum; //单种商品销量总和

    //购物结算
    public GSALES(int gid,int sid, int snum)
    {
        this.gid = gid;
        this.sid = sid;
        this.snum = snum;
    }

    //展现商品列表
    public GSALES(String gname,double gprice,int num,int allSnum)
    {
        this.gname = gname;
        this.gprice = gprice;
        this.gnum = gnum;
        this.allSnum = allSnum;
    }

    //共有set、get
    public int getGid()
    {
        return gid;
    }
    public void setGid(int id)
    {
        gid = id;
    }
    public int getSid()
    {
        return sid;
    }
    public void setSid(int id)
    {
        sid = id;
    }
    public int getSnum()
    {
        return snum;
    }
    public void setSnum(int num)
    {
        snum = num;
    }
    public String getGname()
    {
        return gname;
    }
    public void setGname(String name)
    {
        gname = name;
    }
    public double getGprice()
    {
        return gprice;
    }
    public void setGprice(double price)
    {
        gprice = price;
    }
    public int getGnum()
    {
        return gnum;
    }
    public void setGnum(int num)
    {
        gnum = num;
    }
    public int getAllSnum()
    {
        return allSnum;
    }
    public void setAllSnum(int allSnum)
    {
        this.allSnum = allSnum;
    }
}
