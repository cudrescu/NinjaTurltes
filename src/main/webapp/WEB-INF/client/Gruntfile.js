module.exports = function (grunt) {

	/* set default encoding to utf8 */
	grunt.file.defaultEncoding = 'utf8';

	grunt.initConfig({
		shell: {
			options: {
				stdout: true
			},
			npm_install: {
				command: 'npm install'
			}
		},
		connect: {
			options: {
				port: 9000,
				hostname: 'localhost',
				base:'app'
			},
			proxies: [{
				context: '/apiproxy',
				host: 'localhost',
				port: 8080,
				rewrite: {
					"^/apiproxy/": "/"
				}
			}],
			livereload: {
				options: {
					open: true,
					middleware: function (connect, options) {
						var middlewares = [];

						if (!Array.isArray(options.base)) {
							options.base = [options.base];
						}

						// Setup the proxy
						middlewares.push(require('grunt-connect-proxy/lib/utils').proxyRequest);

						// Serve static files
						options.base.forEach(function (base) {
							middlewares.push(connect.static(base));
						});

						// Make directory browse-able.
						/*var directory = options.directory || options.base[options.base.length - 1];
						middlewares.push(connect.directory(directory));*/

						return middlewares;
					}
				}
			}
		},
		watch: {
			client: {
				files: ['app/**/*'],
				tasks:[],
				options: {
					livereload:true
				}
			}
		},
		open: {
			devserver: {
				path: 'http://localhost:9000',
				app: 'chrome'
			}
		}
	});

	require('matchdep').filterAll(['grunt-*', '!grunt-cli']).forEach(grunt.loadNpmTasks);
	grunt.registerTask('default', ['configureProxies:server', 'connect:livereload', 'open:devserver', 'watch:client']);

};
