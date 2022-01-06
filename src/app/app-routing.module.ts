import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { APP_LAYOUT_ROUTES } from "./routes/app-layout.routes";

const routes: Routes = [
  {
    path: "",
    children: APP_LAYOUT_ROUTES,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
