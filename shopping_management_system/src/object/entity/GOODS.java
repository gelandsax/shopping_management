package object.entity;

/**
 * GOODS 商品实体类
 */
public final class GOODS {
    //数据库GOODS表主键
    private int gid;
    private  String gname;
    private  double gprice;
    private  int gnum;

    //添加所有商品
    public GOODS(String gname,double gprice,int gnum){
        this.gname = gname;
        this.gprice = gprice;
        this.gnum = gnum;
    }

    //展示所有商品信息
    public GOODS(int gid,String gname,double gprice,int gnum){
        this.gid = gid;
        this.gname = gname;
        this.gprice = gprice;
        this.gnum = gnum;
    }

    //根据商品编号更新商品信息
    public GOODS(int gid,int gnum){
        this.gid = gid;
        this.gnum = gnum;
    }

    //根据编号更新商品信息
    public GOODS(int gid, double gprice){
        this.gid = gid;
        this.gprice = gprice;
    }

    //根据编号更新商品信息
    public GOODS(int gid,String gname){
        this.gid = gid;
        this.gname = gname;
    }

    //共有的 get set 方法
    public int getGid(){return gid;}
    public void setGid(int gid){this.gid = gid;}
    public String getGname(){return gname;}
    public void setGname(String ganme){this.gname = gname;}
    public double getGprice(){return gprice;}
    public void setGprice(double gprice){this.gprice = gprice;}
    public int getGnum(){return gnum;}
    public void setGnum(int gnum){this.gnum = gnum;}

}
