ReallySweetSadistic
===================

An RSS agregator in Java

Git Branching Model
-------------------

For this project we use the following git branching model: http://nvie.com/posts/a-successful-git-branching-model/

Service exhibition
------------------

* REST
* MAVEN           (version: 1.3)
* HIBERNATE       (version: 4.2.7.SP1)
* SPRING          (version: 3.2.5.RELEASE)

Service Model
-------------

API

 - Authentication
~~~
	(String userName, String password) : Boolean
~~~

 - Register
~~~
	(String userName, String password) : Boolean
~~~
 
 - Subscribe
~~~
	(String userName, Flow flow) : Boolean
~~~

 - UnSubscribe
~~~
	(String userName, Flow flow) : Boolean
~~~

-------------------------------

READER

 - GetFlows
~~~
  (String userName) : List<Flow>
~~~

 - DisplayFlow
~~~
  (Flow flow)
~~~

-------------------------------

[Flow]
~~~
 - address:  	String
 - title: 	  	String
 - content:	  String
 - lastUpdate: java.util.Date
~~~
