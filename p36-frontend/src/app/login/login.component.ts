import {Component, OnInit} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ifTrue} from "codelyzer/util/function";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    loginFormIsValid: boolean;
    loginForm = this.fb.group({
        emailAddress: ['', [Validators.required, Validators.email]],
        password: ['', Validators.required],

    });

    constructor(private fb: FormBuilder, private router: Router) {
    }

    ngOnInit() {
        this.loginFormIsValid = false;
        this.onChanges();
    }

    onChanges(): void {
        this.loginForm.valueChanges.subscribe(val => {
            if (this.loginForm.get("password").valid && this.loginForm.get("emailAddress").valid) {
                this.loginFormIsValid = true;
            } else {
                this.loginFormIsValid = false;
            }
        });
    }

    isEmailInvalid(): boolean {
        return this.loginForm.get("emailAddress").invalid && this.loginForm.get("emailAddress").dirty;
    }

    isPasswordInvalid(): boolean {
        return this.loginForm.get("password").invalid && this.loginForm.get("password").dirty;
    }

    login(): void{
        console.warn(this.loginForm.value);
        this.router.navigate(["/dashboard"]);
    }
}
