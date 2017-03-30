Hibernate Snowball ID Generator
===
Snowball is an identifier generator inspired by [Twitter Snowflake](https://github.com/twitter/snowflake/), but focuses on easy decentration and intergration with Hibernate in a local network. Snowball generates unique, increasing id in different machines.

### Format
The identifiers that Snowball generates are 64-bit intergers, and format like:
```
|--- unused[1] ---|--- timestamp[41] ---|--- worker[10] ---|--- sequence[12] ---|
```
The 41-bit timestamp ranges from Twitter epoch(2010-11-04T01:42:54.657Z) to 2080-07-10T17:30:30.208Z. And that 10-bit worker id is generated by low 10-bits of ip address. The 12-bit sequence number limits that no more than 4096 identifiers can be generated in 1 milliseconds.

### License
The MIT License.
