# IDEA_untitled
 需求分析：
  1、用户在浏览器输入账号和密码
  2、浏览器将请求传给Tomcat，Tomcat根据request创建Servlet
  3、根据request中的用户名和密码与mysql中的user表作比较
  4、比较结果分别执行failServlet和successServlet
