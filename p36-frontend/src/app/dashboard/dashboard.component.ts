import { Component, OnInit, ElementRef } from '@angular/core';
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  contentId: String;
  constructor() { }

  ngOnInit() {
    this.contentId = "credits";
  }

    menuClick(event) {
      //console.log(event.srcElement.attributes.id.value);
        let elements = document.getElementsByClassName("p36-menu-btn-active")
        if(elements.length != 0){
          elements.item(0).classList.remove("p36-menu-btn-active");
        }
            //
            //.classList.remove("p36-menu-btn-active");
      this.contentId = event.srcElement.attributes.id.value;
        event.srcElement.classList.add("p36-menu-btn-active");
    }
}
