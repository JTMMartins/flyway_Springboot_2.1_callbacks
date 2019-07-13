##SpringBoot 2.1 with Flyway 5.2.4 Java Callbacks

In this mini project we are experimenting with an approach to run code hooked to flyway callbacks.

**Flyway 5.2.4 deprecates many classes and interfaces, wich where used before.**, and as this day I did'nt found a single working example on how to use the new flyway 5.2.4 Callback interface with Springboot 2.1.*. This is my first attempt, and I will continue to investigate on the subject.

This is in continuation of the projet you can find [Flyway experiences](https://github.com/JTMMartins/flyway_experiences) , therefore we assume you already have the Database and Tables already created. 

Run the code on your IDE, and follow the logs.

In debug mode, take a close look to the *event* and  *context* parameters on the **FlywayCallBack** class methods. They are crucial to understand the flow of what is happening, and **when** it happens.

Using the flyway callbacks in this way, is somewhat more powerfull that running the traditional flyway SQL callbacks, as code can be created to run *after a specific* migration (*as already said, examine the context parameter closely*).

Have fun..I did.



Important reading [flyway documentation](https://flywaydb.org/documentation/callbacks.html) 
