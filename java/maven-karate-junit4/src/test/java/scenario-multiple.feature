Feature:

  Scenario:
    * print 'first'

  Scenario:
    * print 'second'

  Scenario:
    * print 'before calling Java code'
    * def Utils = Java.type('Utils')
    * def result = Utils.greet('John')
    * match result == { message: 'Hello John' }