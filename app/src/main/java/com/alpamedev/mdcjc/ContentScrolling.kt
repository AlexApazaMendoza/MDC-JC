package com.alpamedev.mdcjc

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Checkbox
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipBorder
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.MaterialTheme
import com.alpamedev.mdcjc.ui.theme.MDCJCTheme
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContentPreview() {
    MDCJCTheme {
        Content()
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())  //Estados de la barra de desplazamiento
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                val image = ContextCompat.getDrawable(LocalContext.current, R.drawable.ic_store)
                Image(bitmap = image!!.toBitmap().asImageBitmap(), contentDescription = null)
                Button(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_store), contentDescription = null)
                    Text(text = stringResource(id = R.string.card_btn_buy))
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.card_btn_skip))
                }
                Text(
                    text = stringResource(id = R.string.card_title),
                    style = MaterialTheme.typography.title1,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = stringResource(id = R.string.large_text),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Start,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        var colorMain by remember {
            mutableStateOf(Color.LightGray)
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = colorMain)
        ) {
            Column {
                /*Image(
                    painter = painterResource(id = R.drawable.ic_store),
                    contentDescription = null,
                    modifier = Modifier
                        .background(color = colorResource(id = R.color.teal_200))
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.card_img_cover_height))
                )*/
                var urlValue by remember {
                    mutableStateOf("ANT")
                }
                GlideImage(
                    model = urlValue,
                    contentDescription = null,
                    modifier = Modifier
                        .background(color = colorResource(id = R.color.teal_200))
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.card_img_cover_height)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(id = R.string.card_title),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.common_padding_default)),
                    style = MaterialTheme.typography.title3
                )
                OutlinedTextField(
                    value = urlValue,
                    onValueChange = { urlValue = it },
                    label = { Text(text = stringResource(id = R.string.card_input_url)) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(id = R.dimen.common_padding_default),
                            start = dimensionResource(id = R.dimen.common_padding_default),
                            end = dimensionResource(id = R.dimen.common_padding_default)
                        ),
                    trailingIcon = {
                        if (urlValue.isNotEmpty()) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = "Clear",
                                modifier = Modifier.clickable {
                                    urlValue = ""
                                }
                            )
                        }
                    }
                )
                Text(
                    text = stringResource(id = R.string.card_required),
                    style = MaterialTheme.typography.caption1,
                    color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.common_padding_default),
                            end = dimensionResource(id = R.dimen.common_padding_default),
                            top = dimensionResource(id = R.dimen.common_padding_min)
                        )
                )
                var passwordValue by remember {
                    mutableStateOf("")
                }
                var isCheckboxEnabled by remember {
                    mutableStateOf(false)
                }
                var isPasswordVisible by remember {
                    mutableStateOf(false)
                }
                OutlinedTextField(
                    value = passwordValue,
                    onValueChange = { passwordValue = it },
                    label = { Text(text = stringResource(id = R.string.card_password)) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(id = R.dimen.common_padding_default),
                            start = dimensionResource(id = R.dimen.common_padding_default),
                            end = dimensionResource(id = R.dimen.common_padding_default)
                        ),
                    enabled = isCheckboxEnabled,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        Icon(
                            painter = if (isPasswordVisible) painterResource(id = R.drawable.ic_visibility) else painterResource(id = R.drawable.ic_disabled_visible),
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                isPasswordVisible = !isPasswordVisible
                            }
                        )
                    }
                )
                var isSwitchChecked by remember {
                    mutableStateOf(true)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = isCheckboxEnabled,
                        onCheckedChange = {
                            isCheckboxEnabled = it
                        },
                        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.common_padding_default))
                    )
                    Text(text = stringResource(id = R.string.card_enable_pass))
                    Spacer(modifier = Modifier.weight(1f, true))
                    Text(text = stringResource(id = R.string.card_hide_fab))
                    Switch(
                        checked = isSwitchChecked,
                        onCheckedChange = {isCheckboxEnabled = it},
                        modifier = Modifier.padding(end = dimensionResource(id = R.dimen.common_padding_default))
                    )
                }
                var sliderValue by remember {
                    mutableFloatStateOf(6f)
                }
                val context = LocalContext.current
                Slider(
                    value = sliderValue,
                    onValueChange = {
                        sliderValue = it
                        urlValue = "Vol: ${it.toInt()}"
                    },
                    onValueChangeFinished = {
                        Toast.makeText(context, "Value: ${sliderValue.toInt()}", Toast.LENGTH_SHORT).show()
                    },
                    valueRange = 0f..10f,
                    steps = 4,
                )
                val chipValue by remember {
                    mutableStateOf("alex@gmail.com")
                }
                var chipVisible by remember {
                    mutableStateOf(true)
                }
                if (chipVisible) {
                    Chip(
                        onClick = {
                            Toast.makeText(context, chipValue, Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.common_padding_default)
                            ),
                        colors = ChipDefaults.primaryChipColors(),
                        border = ChipDefaults.chipBorder()
                    ) {
                        Text(text = chipValue)
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = null,
                            modifier = Modifier
                                .size(16.dp)
                                .clickable { chipVisible = false }
                        )
                    }
                }
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = dimensionResource(id = R.dimen.common_padding_middle))
                )
                var colors = listOf("Red", "Green", "Blue")
                SegmentedControl(
                    items = colors,
                    defaultSelectedItemIndex = -1,
                    cornerRadius = 48,
                    color = R.color.purple_200,
                    onItemSelection = {
                        colorMain = when (it) {
                            0 -> Color.Red
                            1 -> Color.Green
                            else -> Color.Blue
                        }
                    }
                )
            }
        }
    }
}