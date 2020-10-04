# NavigationGraphExample

Replacing `<fragment>` with `<androidx.fragment.app.FragmentContainerView>` in `content-main.xml` may cause this run-time-error: 

```
2020-10-04 19:50:26.946 9460-9460/no.rogo.navigationgraphexample E/AndroidRuntime: FATAL EXCEPTION: main
    Process: no.rogo.navigationgraphexample, PID: 9460
    java.lang.RuntimeException: Unable to start activity ComponentInfo{no.rogo.navigationgraphexample/no.rogo.navigationgraphexample.ui.activities.MainActivity}: java.lang.IllegalStateException: Activity no.rogo.navigationgraphexample.ui.activities.MainActivity@dfc7880 does not have a NavController set on 2131231008
```

To cope with this situation, you can use `navHostFragment`

Change this line in `MainActivity.kt`s `onCreate`

```
val navController = findNavController(R.id.nav_host_fragment_content_main)
```
to
```
val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
val navController = navHostFragment.navController
```

RG
