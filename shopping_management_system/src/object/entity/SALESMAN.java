package object.entity;

/**S
 * ALESMAN 售货员实体类
 */
public final class SALESMAN {
    private int sid;
    private String sname;
    private String spassword;

    //验证用户登录
    public SALESMAN(int sid,String spassword){
        this.sid = sid;
        this.spassword = spassword;
    }

    //查询用户、更改用户密码
    public SALESMAN(int sid, String sname,String spassword){
        this.sid = sid;
        this.sname = sname;
        this.spassword = spassword;
    }

    //添加用户
    public SALESMAN(String sname,String spassword){
        this.sname = sname;
        this.spassword = spassword;
    }

    //共有 get set 方法
    public int getSid(){return sid;}
    public void setSid(int sid){this.sid = sid;}
    public String getSname(){return sname;}
    public void getSname(String sname){this.sname = sname;}
    public String getSPassWord(){return spassword;}
    public void setSPassWord(String spassword){this.spassword = spassword;}

}
