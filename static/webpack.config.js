const webpack = require('webpack');
const path = require('path');

/*
 * We've enabled UglifyJSPlugin for you! This minifies your app
 * in order to load faster and run less javascript.
 *
 * https://github.com/webpack-contrib/uglifyjs-webpack-plugin
 *
 */


module.exports = {
	entry: './index',
	output: {
		filename: '[name].bundle.js',
		path: path.resolve(__dirname, 'dist'),
    publicPath: 'dist'
	},

	module: {
		rules: [
			{
				test: /\.js$/,
				exclude: /node_modules/,
				loader: 'babel-loader',
				options: {
					presets: ['es2015']
				}
			}
		]
	},

  devServer: {
    inline: true,
    contentBase: '.',
    host: '0.0.0.0',
    disableHostCheck: true
  }
};
