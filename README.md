# shopping_management_System

## 购物管理系统



项目结构：

`-- src

    `-- object

        |-- dao

        |   |-- GOODSDao.java

        |   |-- GSALESDao.java

        |   `-- SALESMANDao.java

        |-- db

        |   |-- Dbclose.java

        |   `-- Dbconnection.java

        |-- entity

        |   |-- GOODS.java

        |   |-- GSALES.java

        |   `-- SALESMAN.java

        |-- page

        |   |-- GoodsPage.java

        |   |-- GsalesPage.java

        |   |-- MainPage.java

        |   `-- SalesManPage.java

        `-- tools

            |-- Arith.java

            |-- QueryPrint.java

            `-- ScannerChoice.java

1.软件设计概述
--------

### 1.1开发背景

大型商超或者网络商城不同于小型商店，往往具有库存商品种类繁多、交易频率较高、库存变动频繁且复杂等特点，并且大型商超还面临着人员管理问题，如此复杂的需求使用传统的管理方式显得效率低且极容易出现错误，因此需要数字化的管理系统。本商超购物管理系统具有购买商品、商品管理（添加商品、修改商品信息、删除商品）、前台收银、商品库存管理、售货员管理等基本功能。

### 1.2目的意义

本项目可作为大型商超或者网络商城的综合后台管理系统，整合了购买、商品库存管理、营业额统计、人员管理等业务，一站式地解决了商超或网络商城管理。

### 1.3需求分析

#### 1.3.1业务需求

1.   业务流程：

进入系统时会首先显示主界面，在主界面可以根据指引选择想要进行的操作

l  商品维护

l  前台收银

l  商品管理

如下图所示：

2.   关键业务目标

l  保证数据录入正确

l  保证搜索的速度和准确性

#### 1.3.2系统具体功能需求

1.   主界面

显示选项以供用户选择具体的服务

l  商品维护

l  前台收银

l  商品管理

2.   商品维护界面

显示具体操作选项供用户选择

l  添加商品：输入商品价格应为大于0的实数，商品数量应为大于0的实数，否则显示输入错误。输入Y/y继续进行添加操作，输入N/n返回商品维护界面。

l  更改商品：输入要更改的商品名，系统会显示所选择的商品的全部属性。选择要更改的商品的属性（价格、数量等），整个过程是可循环重复的。输入Y/y继续进行修改操作，输入N/n返回商品维护界面。

l  删除商品：输入要删除的商品名，系统会显示该商品的全部属性。输入Y/y继续进行删除操作，输入N/n返回商品维护界面。

l  显示所有商品：在界面上显示全部商品的全部信息，若某商品数量小于10，则在备注中显示“该商品已不足十件“，否则无任何显示。输入0返回商品维护界面。

l  查询商品：提供三种查询方式

1)   按商品数量升序查询

2)   按商品价格升序查询

3)   按输入商品名查询

输入0返回商品维护界面。

3.   前台收银界面

显示具体操作选项供用户选择

l  登录系统：在界面上输入用户名和密码，如果用户名和密码输入正确则登录成功进入购物结算功能界面，否则显示提示信息“用户名和密码不匹配“。共有3次输入机会，如果3次输入都错误则退出系统。

u  登录成功后询问是否进入购物结算界面，输入S/s进入购物结算界面，输入0返回登录界面。

1)   输入商品关键字（首字母或第一个字），系统查询到后会显示带有关键字全部商品信息。

2)   输入想要购买的商品的商品编号。

3)   输入购买的数量。

4)   系统返回购物信息（商品名、单价、数量、总价）

5)   输入Y/y继续进行购买操作，输入N/n返回购物结算界面。

6)   系统显示购买商品的总价，用户输入实际交付金额，系统返回找零金额，并显示“谢谢光临，欢迎下次惠顾！“

7)   返回购物结算界面。

l  退出：返回主界面。

4.   商品管理界面

显示具体操作选项供用户选择

l  列出当日卖出商品列表：系统返回当日售卖出的全部商品列表，若某商品库存不足十件则在备注显示“该商品已不足十件“，否则不做任何显示。操作完成后输入0返回上级菜单。

l  售货员管理：选择后进入售货员管理界面

u  添加售货员

按照系统提示输入售货员的姓名的密码，输入成功后将售货员信息写入到售货员表中。可以循环执行该操作。

u  更改售货员信息

1)   正确输入要更新的售货员姓名，然后根据售货员姓名查询售货员信息。

2)   在界面上显示查询出来的商售货员信息，如果没有满足条件的售货员则显示“该售货员不存在！”。

3)   选择要修改的售货员信息，请入1或者2

4)   输入要更改的售货员信息，并把更改后的售货员信息进行保存。（可以循环的多次操作更改售货员的功能，选择y可以继续更改售货员信息）

u  删除售货员

1)   正确输入要删除的售货员姓名，然后根据售货员姓名查询售货员信息

2)   在界面上显示查询出来的售货员信息，如果没有满足条件的商售货员则显示“该售货员不存在！”

3)   删除售货员信息。（备注：1、删除之前有个确认提示“是否确定要删除（y/n）？”，如果选择y才删除，否则不做任何处理。2、可以循环的多次操作删除售货员的功能，选择y可以继续删除售货员信息）

u  查询售货员

1)   在界面上输入查询条件（按售货员姓名关键字查询--支持模糊查询）

2)   显示满足条件的售货员信息列表（支持多次查询）

u  显示所有售货员

1)   在界面上显示查询出来的售货员信息
