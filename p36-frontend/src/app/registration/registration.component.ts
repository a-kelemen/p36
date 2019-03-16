import {Component, OnInit, OnChanges, SimpleChanges, ViewChild} from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';

@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
    regForm = this.fb.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required],
        emailAddress: ['', Validators.required/*, Validators.email*/],
        address: this.fb.group({
            country: ['', Validators.required],
            state: [''],
            zip: ['', Validators.required],
            city: ['', Validators.required],
            street: ['', Validators.required]
        }),
    });
    //@ViewChild('regForm') regForm;



    // regForm = new FormGroup({
    //     firstName: new FormControl(''),
    //     lastName: new FormControl(''),
    //     emailAddress: new FormControl(''),
    //     country: new FormControl(''),
    //     state: new FormControl(''),
    //     zip: new FormControl(''),
    //     city: new FormControl(''),
    //     street: new FormControl('')
    // });
    //firstName = new FormControl('');
    // lastName = new FormControl('');

    personalForm: boolean;
    addressForm: boolean;
    lastNameField: any;
    emailField: any;
    firstNameField: any;
    private personalValid: boolean;

    constructor(private fb: FormBuilder) { }

    ngOnInit() {
        this.personalForm = true;
        this.addressForm = false;
        this.lastNameField = this.regForm.get('lastName');
        this.firstNameField = this.regForm.get('firstName');
        this.emailField = this.regForm.get('emailAddress');
        this.onChanges();
        this.personalValid = false;
    }


    goToNextStep(): void {
        // (this.lastNameField.invalid || this.firstNameField.invalid || this.emailField.invalid)
        this.personalForm = false;
        this.addressForm = true;
    }


    submitRegData() {

    }

    onSubmit() {
        console.warn(this.regForm.value);
        console.warn(this.regForm.status);
        console.warn(this.regForm.get('lastName').invalid);
    }

    onChanges(): void {
            this.regForm.valueChanges.subscribe(val => {
            this.isPersonalValid()
        });
    }

    private isPersonalValid(): void {
        if(this.lastNameField.valid && this.firstNameField.valid && this.emailField.valid){
          this.personalValid = true;
        }else{
            this.personalValid = false;
        }
    }
}

