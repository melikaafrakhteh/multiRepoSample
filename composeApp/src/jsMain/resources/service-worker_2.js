const CACHE_NAME = 'app-cache-v12';
const assetsToCache = [
  '/',
  '/index.html',
  '/manifest.json',
  '/composeApp.js',  // Compose Multiplatform JS bundle
  '/skiko.js',       // Skiko JavaScript glue code
  '/skiko.wasm',     // WebAssembly file for Skia rendering
];

self.addEventListener('install', (event) => {
  event.waitUntil(
    caches.open(CACHE_NAME).then((cache) => {
      return cache.addAll(assetsToCache);
    })
  );
  self.skipWaiting();
});

self.addEventListener('activate', (event) => {
console.log("Delete cache")
  event.waitUntil(
    caches.keys().then((keyList) => {
      return Promise.all(
        keyList.map((key) => {
          if (key !== CACHE_NAME) {
            return caches.delete(key);
          }
        })
      );
    })
  );
});
/*

self.addEventListener('message', (event) => {
    if (event.data.action === 'skipWaiting') {
        self.skipWaiting(); // Skips waiting state and activates the new service worker immediately
    }
});*/
