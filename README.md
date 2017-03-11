# react-native-dns

React Native library for getting dns information

## Usage

First you need to install react-native-dns:

```javascript
npm install react-native-dns --save
```

### `iOS`

//@todo

### `Android`

* `android/settings.gradle`

```gradle
...
include ':react-native-dns'
project(':react-native-dns').projectDir = new File(settingsDir, '../node_modules/react-native-dns/android')
```
* `android/app/build.gradle`

```gradle
dependencies {
	...
	compile project(':react-native-dns')
}
```

* register module (in MainApplication.java)

```java
...

import me.naxel.rndns.RNDNSPackage; // <--- IMPORT

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
	...

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new RNDNSPackage() // <- ADD HERE
      );
    }
  };
  	...
}
```

## Example

```javascript

// require module
const dns = require('react-native-dns');

dns.lookup('naxel.me', function (err, ip) {
  console.log(err, ip);
});

```
