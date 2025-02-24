import { ProvidePlugin } from 'webpack';

export const plugins = [
    new ProvidePlugin({
        global: 'global', // Add the global polyfill
    }),
];
