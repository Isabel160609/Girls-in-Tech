


// export class LocationModel {
//  public name?: string;
//  public  type?: string; //color
//  public activity?: string;
//  public address!: Address[];
//  public radio?: number;
//  public description?: string;




// }

// class Address {
//  public street_name!: string;
//  public street_number?: string | number;
//  public zip_code?: string;
//  public town?: string;
//  public location!: {
//     x: number;
//     y: number;
//   };


// }

export class LocationModel{
public  id?: number;
  public location!: {
    id_location?: number;
    x: number;
    y: number;
  };
  public activity!: string;
  public radio?: number;
  public name?: string;
  public address!: {
       idAddress?: number;
       street: string;
       number: number;
      cp?: number;
      city: string;
  };
  public color!: string;
  public verified?: boolean
  public why?: string
}


