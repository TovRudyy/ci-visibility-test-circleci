Install deps with:

```sh
yarn install
```

Run with:

```
NODE_OPTIONS="-r dd-trace/ci/init" DD_ENV=ci DD_SERVICE=my-javascript-app DD_TRACE_DEBUG=true yarn test
```
