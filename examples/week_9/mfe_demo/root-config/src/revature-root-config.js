import { registerApplication, start } from "single-spa";

registerApplication({
  name: "@revature/angular-app",
  app: () => System.import("@revature/angular-app"),
  activeWhen: ["/products"]
})

registerApplication({
  name: "@revature/react-app",
  app: () => System.import("@revature/react-app"),
  activeWhen: ["/"]
})

start({
  urlRerouteOnly: true,
});
