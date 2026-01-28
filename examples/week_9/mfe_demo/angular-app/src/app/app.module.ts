import { NgModule, provideBrowserGlobalErrorListeners } from "@angular/core";
import { App } from "./app";
import { BrowserModule } from "@angular/platform-browser";
import { CommonModule } from "@angular/common";

@NgModule({
    declarations: [
        App
    ],
    imports: [
        BrowserModule,
        CommonModule
    ],
    providers: [
        provideBrowserGlobalErrorListeners()
    ],
    bootstrap: [App]
})
export class AppModule {}