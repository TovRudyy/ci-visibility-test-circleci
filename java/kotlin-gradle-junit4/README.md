### Running in Agentless mode

Set the `DD_API_KEY` environment and use `run.sh` script:

```
DD_API_KEY=... DD_TRACER_VERSION=... ./run.sh
```

where `DD_TRACER_VERSION` is the version of the tracer you want to use (e.g. `1.11.0`, or `1.12.0-SNAPSHOT`).

----

### Verifying results

The results will be reported to [staging](https://dd.datad0g.com/ci/test-runs?query=test_level%3Atest%20%40test.service%3Aciapp-test-kotlin-gradle-junit4) 
with service name `ciapp-test-kotlin-gradle-junit4`.
