
#### Configuration for JMS /ActiveMQ

The project uses JMS to demonstrate sending and receiving messages asynchronously. Wildfly full profile must be used.

To start Wildfly server use the following command:

```
$ standalone.sh -c standalone-full.xml
```

A JMS queue must be added before deploying the application. To add a JMS queue, use the following commands. The first
command connects to a running Wildfly server and the second creates a queue. Note: The JNDI name must match the name in
the code.

```
$ jboss-cli.sh --connect
[standalone@localhost:9990 /] jms-queue add --queue-address=myQueue --entries=java:/jms/myapp/myqueue
[standalone@localhost:9990 /] quit
```
