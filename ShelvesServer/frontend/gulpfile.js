"use strict"

var gulp = require('gulp');
var browserify = require('browserify');
var babelify = require('babelify');
var source = require('vinyl-source-stream');
var connect = require('gulp-connect');


/*
gulp.task('connect', function() {
    connect.server({
        port: 8888,
        root: 'app/dist',
        livereload: true
    });
});

gulp.task('html', function() {
    gulp.src('./app/dist/index.html')
        .pipe(connect.reload())
});
*/

gulp.task('build', /* ['html'], */ function() {
    return browserify({entries: './app/src/index.js', extensions: ['.jsx'], debug: true})
        .transform('babelify', {presets: ['es2015', 'react'],
                                plugins: ["transform-object-rest-spread"]})
        .bundle()
        .pipe(source('app.js'))
        .pipe(gulp.dest('app/dist/js'));
});

gulp.task('copy', ['build'], function(){
    gulp.src('app/src/assets/**/*.*')
        .pipe(gulp.dest('app/dist/assets'));
    gulp.src('app/src/index.html')
        .pipe(gulp.dest('app/dist'));
});

gulp.task('watch', function () {
    gulp.watch('app/src/*.js', ['copy']);
    gulp.watch(['app/src/*.*', 'app/src/pages/*.js', 'app/src/components/*.js', 'app/src/assets/css/added.css'], ['copy']);
});

gulp.task('default', ['copy', 'watch']);