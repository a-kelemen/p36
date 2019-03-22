import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'P36';
    mainTitle: boolean;

    public onRouterOutletActivate(event : any) {
        var component = event.constructor.name;
        var cArray = ["LoginComponent", "RegistrationComponent", "StartPageComponent"];
        if(cArray.indexOf(component) > -1){
          this.mainTitle = false;
        }else{
            this.mainTitle = true;
        }
    }
}
