import {Component, OnInit} from '@angular/core';

import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
    regForm = this.fb.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        emailAddress: ['', [Validators.required, Validators.email]],
        passw1: ['', Validators.required],
        passw2: ['', Validators.required],
        address: this.fb.group({
            country: ['', Validators.required],
            state: [''],
            zip: ['', Validators.required],
            city: ['', Validators.required],
            street: ['', Validators.required]
        }),
    });

    personalForm: boolean;
    addressForm: boolean;
    lastNameField: any;
    emailField: any;
    passw1: any;
    passw2: any;
    firstNameField: any;
    private personalValid: boolean;

    constructor(private fb: FormBuilder, private router: Router) { }

    ngOnInit() {
        this.personalForm = true;
        this.addressForm = false;
        this.lastNameField = this.regForm.get('lastName');
        this.firstNameField = this.regForm.get('firstName');
        this.emailField = this.regForm.get('emailAddress');
        this.passw1 = this.regForm.get('passw1');
        this.passw2 = this.regForm.get('passw2');
        this.onChanges();
        this.personalValid = false;
    }


    goToNextStep(): void {
        // (this.lastNameField.invalid || this.firstNameField.invalid || this.emailField.invalid)
        this.personalForm = false;
        this.addressForm = true;
    }


    submitRegData() {
        // submit data
        console.warn(this.regForm.value);
        this.router.navigate(["/dashboard"]);
    }

    onSubmit() {
        console.warn(this.regForm.value);
        console.warn(this.regForm.status);
    }

    onChanges(): void {
            this.regForm.valueChanges.subscribe(val => {
            this.isPersonalValid()
        });
    }

    private isPersonalValid(): void {
        if(this.lastNameField.valid
            && this.firstNameField.valid
            && this.emailField.valid
            && this.passw1.valid
            && this.passw2.valid){
            if(this.passw1.value == this.passw2.value){
                this.personalValid = true;
            }else{
                //console.log("passwerror");
            }
        }else{
           // console.log("invalid");
            this.personalValid = false;
        }
    }
    isInputInvalid(field: string):boolean{
        return this.regForm.get(field).invalid && this.regForm.get(field).dirty;
    }
    isAddressInputInvalid(field: string):boolean{
        return this.regForm.get('address').get(field).invalid && this.regForm.get('address').get(field).dirty;
    }

    isPasswordInvalid() :boolean{
        return this.passw1.value != this.passw2.value
            && this.passw2.dirty;
    }
}

