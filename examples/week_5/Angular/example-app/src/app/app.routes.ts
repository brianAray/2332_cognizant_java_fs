import { Routes } from '@angular/router';
import { Hello } from './hello/hello';
import { ParentExample } from './parent-example/parent-example';
import { AccessParamsExample } from './access-params-example/access-params-example';
import { ProductListComponent } from './product-list-component/product-list-component';
import { SignalExample } from './signal-example/signal-example';
import { PostListComponent } from './post-list-component/post-list-component';
import { ObservableExample } from './observable-example/observable-example';

export const routes: Routes = [
    {path: '', redirectTo: 'hello', pathMatch: 'full'},
    {path: 'hello', component: Hello},
    {path: 'parent', component: ParentExample},
    {path: 'access-params/:id', component: AccessParamsExample},
    {path: 'products', component: ProductListComponent},
    {path: 'signals', component: SignalExample},
    {path: 'http', component: PostListComponent},
    {path: 'observable', component: ObservableExample}
];
