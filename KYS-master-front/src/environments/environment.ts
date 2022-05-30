// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  MAPBOX_TOKEN: 'pk.eyJ1Ijoidm9sdW50YXRhIiwiYSI6ImNsM3BnbmNtMjAwYWUza3A3Yjd0cnVrYXAifQ.uY8ZMFujuFc2TNXw0i03XA',
  MAPBOX_ZOOM: 8,
  MAPBOX_STYLE: 'mapbox://styles/mapbox/streets-v11',
  BACKEND_BASE_URL: '',
  DATE_TO_PRINT_ON_MAP: 'http://localhost:8080/points',
  GREEN_DATA:'http://localhost:8080/pointColor/green',
  YELLOW_DATA: 'http://localhost:8080/pointColor/yellow',
  RED_DATA: 'http://localhost:8080/pointColor/red',
  PURPLE_DATA:'http://localhost:8080/pointColor/purple',
  USER_DATA: 'http://localhost:8080/user'



};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
