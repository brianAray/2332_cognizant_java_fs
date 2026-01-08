import { createContext } from "react";
import type { User } from "./User";

export const DashboardContext = createContext<User | undefined>(undefined);