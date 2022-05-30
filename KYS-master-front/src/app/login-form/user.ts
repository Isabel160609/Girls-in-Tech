export class User {

  email: string;
  password: string;
  registered?: boolean

  constructor(user?:any){

    this.email = user.email || null;
    this.password = user.password || null;

  }
}
