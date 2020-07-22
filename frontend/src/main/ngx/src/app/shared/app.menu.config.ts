import { MenuRootItem } from 'ontimize-web-ngx';

export const MENU_CONFIG: MenuRootItem[] = [
  { id: 'home', name: 'HOME', icon: 'home', route: '/main/home' },
  { id: 'offers', name: 'OFFERS', icon: 'work', route: '/main/offers' },
  { id: 'candidates', name: 'CANDIDATES', icon: 'people', route: '/main/candidates' },
  { id: 'logout', name: 'LOGOUT', route: '/login', icon: 'power_settings_new', confirm: 'yes' }
];
