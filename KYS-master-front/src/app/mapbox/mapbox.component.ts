import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { AfterViewInit, Component, ViewChild, ElementRef, Input, ViewChildren, QueryList, Renderer2 } from '@angular/core';
import Mapboxgl, { LngLatBounds, NavigationControl, GeolocateControl, Map, Popup, Marker} from "mapbox-gl"
import { environment } from 'src/environments/environment';
import { LocationModel } from 'src/models/location.model';
import { MapboxService } from './mapbox.service';


@Component({
  selector: 'app-mapbox',
  templateUrl: './mapbox.component.html',
  styleUrls: ['./mapbox.component.css']
})


export class MapboxComponent implements AfterViewInit {
  @ViewChild("mapDiv")
  mapDivElement!: ElementRef;

  @ViewChildren('mapboxgl-marker') markers!: QueryList<any>;

  private map!: Map;
  private currentMarkers: Marker[] = [];
  element: any;

  private MAPBOX_INIT_LOCATION: LocationModel = {

      location: {
          "x": 1.1,
          "y": 1.2
      },
      activity: "park",
      radio: 2,
      name: "el retiro",
      address: {
          street: "gran via",
          number: 211,
          cp: 28008,
          city: "Madrid"
      },
      color: "RED",


  }

  filteredResultsToPrintOnMap!: LocationModel;
  constructor( private service: MapboxService) {

  }

  ngAfterViewInit(): void {
    // Generate map with basic config
    this.generateMap();
    // Depending on if the user accepts to share their location, center the map into the user, or into the default location (IT Academy)
    this.getUsersLocation();
    this.showAll();
  }

 showAll(){
  this.currentMarkers.forEach(marker => marker.remove());
  this.service.getAlldata().subscribe(responce =>
    { responce.forEach(element => {
           if (element.color === "GREEN") {
      this.createANewMarker("green", element);
    }
    if (element.color === "RED") {
      this.createANewMarker("red", element);
    }
    if (element.color === "YELLOW") {
      this.createANewMarker("yellow", element);
    }
    if (element.color === "PURPLE") {
      this.createANewMarker("purple", element);
    }

    });
    console.log(responce)
});


 }

 showSafe(){
   this.currentMarkers.forEach(marker => marker.remove());
   this.getUsersLocation();
   this.service.getGreen().subscribe(responce => responce.forEach((result) => {
      // Create a marker for each result and add it to the map
          this.createANewMarker("green", result);
        }))
 }

 showDanger(){
   this.currentMarkers.forEach(marker => marker.remove());
   this.getUsersLocation();
   this.service.getRed().subscribe(responce => responce.forEach((result) => {
    // Create a marker for each result and add it to the map
        this.createANewMarker("red", result);
      }))
 }

 showHelp(){
   this.currentMarkers.forEach(marker => marker.remove());
   this.getUsersLocation();
   this.service.getPurple().subscribe(responce => responce.forEach((result) => {
    // Create a marker for each result and add it to the map
        this.createANewMarker("purple", result);
      }))
 }

 showFriends(){
    this.currentMarkers.forEach(marker => marker.remove());
    this.getUsersLocation();
    this.service.getYellow().subscribe(responce => responce.forEach((result) => {
     // Create a marker for each result and add it to the map
         this.createANewMarker("yellow", result);
       }))

 }
  ngOnDestroy() {
    this.currentMarkers.forEach(marker => marker.remove());
  }

  generateMap() {
    Mapboxgl.accessToken = environment.MAPBOX_TOKEN;
    this.map = new Map({
      container: this.mapDivElement.nativeElement,
      style: environment.MAPBOX_STYLE,
      // center: [this.MAPBOX_INIT_LOCATION.address[0].location.x, this.MAPBOX_INIT_LOCATION.address[0].location.y], // starting center so it doesn't start from Germany
      zoom: environment.MAPBOX_ZOOM
    });

    this.map.addControl(new NavigationControl());

    // Add geolocate control to the map.
    this.map.addControl(
      new GeolocateControl({
        positionOptions: {
          enableHighAccuracy: true,
        },
        trackUserLocation: true,
      })
    );

  }

  // Function to create a single marker (with the marker's colour and the business (or user's coords) as parameters)
  createANewMarker(markerColor: string, business?: LocationModel, coord?: GeolocationCoordinates): void {

    // Create a popup with the business's basic information
    const popup = new Popup().setHTML(
      `<b>${business?.name}</b> </br> ${business?.address.street} , ${business?.address.number}`
    );

    if (coord) { // If user has accepted to share their location

      const newIndividualMarker = new Marker({ color: markerColor })
        .setLngLat([coord.longitude, coord.latitude])
        .addTo(this.map);
      this.currentMarkers.push(newIndividualMarker);
    } else { // If user hasn't accepted to share their location OR when iterating through the filteredResultsToPrintOnMap array.
      const newIndividualMarker = new Marker({ color: markerColor })
        .setLngLat([business!.location.x, business!.location.y])
        .setPopup(popup)
        .addTo(this.map);
      this.currentMarkers.push(newIndividualMarker);
    }

    // MAP LÍMITS
    // Initial point 0
    const bounds = new LngLatBounds();

    // Add all the markers to the map's bounds.
    this.currentMarkers.forEach(marker =>
      bounds.extend(marker.getLngLat()));
    //console.log(bounds)
    // Adjust the zoom to see all the existing markers
    this.map.fitBounds(bounds, {
      padding: 75
    })
  }

  getUsersLocation(): void {
    navigator.geolocation.getCurrentPosition(
      // Success callback function (if user has accepted to share their location)
      (pos) => {
        // this.map.flyTo({ center: [pos.coords.longitude, pos.coords.latitude], zoom: 11 })
        this.createANewMarker("blue", undefined, pos.coords);
       // console.log(pos.coords)
      },
      // Error callback function (if user hasn't accepted to share their location)
      () => {
        // this.map.flyTo(
        //  { center: [environment.MAPBOX_ITAcademy_OBJECT.addresses[0].location.x, environment.MAPBOX_ITAcademy_OBJECT.addresses[0].location.y], zoom: 11 })
        this.createANewMarker("blue", this.MAPBOX_INIT_LOCATION);
      }
    );
  }
}
