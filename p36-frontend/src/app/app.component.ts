import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'P36';
    mainTitle: boolean;

    public onRouterOutletActivate(event: any) {
        const component = event.constructor.name;
        const cArray = ['LoginComponent', 'RegistrationComponent', 'StartPageComponent'];
        if (cArray.indexOf(component) > -1) {
          this.mainTitle = false;
        } else {
            this.mainTitle = true;
        }
    }
}
