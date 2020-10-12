package co.uk.thewirelessguy.spacexrockets.extension

import android.widget.ImageView
import coil.load

/**
 * Wraps the image loading library with an extension to simplify image loading and to make it
 * make it easier to swap out libraries at a later date.
 *
 * Coil - Image loading for Android backed by Kotlin Coroutines.
 * @link https://coil-kt.github.io/coil/
 */

fun ImageView.loadUrl(url: String) {
    this.load(url)
}
