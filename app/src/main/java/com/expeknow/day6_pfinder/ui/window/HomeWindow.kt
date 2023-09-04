package com.expeknow.day6_pfinder.ui.window

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.expeknow.day6_pfinder.R
import com.expeknow.day6_pfinder.ui.theme.gardenC
import com.expeknow.day6_pfinder.ui.theme.helveticalMedium
import com.expeknow.day6_pfinder.ui.utils.petDataList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeWindow() {

    val baseModifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
    Scaffold(containerColor = Color.White) {

        Column(Modifier.padding(it)) {
            TopBar(baseModifier)
            SearchBar(baseModifier)
            FilterChips(baseModifier)
            Animals(baseModifier)
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Animals(modifier: Modifier = Modifier) {
    val petsList = petDataList

    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2), modifier = modifier) {
        this.items(petsList.size) {
            val index = it
            val petData = petsList[index]
            Card(shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)) {
                Column() {
                    Card(shape = RoundedCornerShape(15.dp), modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()) {

                        Box() {
                            Image(painter = painterResource(id = petData.imageID), contentDescription = "",
                                contentScale = ContentScale.Crop)
                            Row(modifier = Modifier.padding(10.dp)) {
                                Spacer(modifier = Modifier.weight(1f))
                                Card(shape = RoundedCornerShape(80.dp),
                                    elevation = CardDefaults.cardElevation(10.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = colorResource(id = R.color.translucent_gray)
                                    )) {
                                    Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "",
                                        tint = Color.White, modifier = Modifier.padding(5.dp).size(16.dp))
                                }
                            }
                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    val textModifier = Modifier.padding(horizontal = 10.dp)
                    Text(text = petData.fullName, fontSize = 12.sp, color = Color.Black,
                        modifier =textModifier, lineHeight = 18.sp, fontWeight = FontWeight.SemiBold,
                        letterSpacing = 0.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(textModifier) {
                        val icon = if(petData.gender == "Male") painterResource(id = R.drawable.male)
                        else painterResource(id = R.drawable.female)

                        Icon(painter = icon, contentDescription = "location",
                            tint = colorResource(id = R.color.secondary_yellow), modifier = Modifier.size(15.dp))
                        Text(text = petData.gender, color = Color.Gray, fontSize = 10.sp)
                        
                        Spacer(modifier = Modifier.width(15.dp))

                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = "location",
                            tint = colorResource(id = R.color.secondary_yellow), modifier = Modifier.size(15.dp))
                        Text(text = "${petData.ageInYears} years", color = Color.Gray, fontSize = 10.sp)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = petData.location, color = Color.Gray, fontSize = 10.sp, modifier =textModifier)

                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChips(modifier: Modifier = Modifier) {

    val tabsItem = listOf(
        "All",
        "Cats",
        "Dogs",
        "Birds",
    )

    val imageIds = listOf(
        R.drawable.all,
        R.drawable.cat2,
        R.drawable.dog4,
        R.drawable.bird4
    )

    LazyRow(modifier.padding(horizontal = 0.dp)) {
        items(tabsItem.size){
            val tabName = tabsItem[it]
            val imageId = imageIds[it]
            val state = remember { mutableStateOf(false) }
            FilterChip(
                selected = state.value,
                onClick = {
                    state.value = !state.value
                },
                shape = RoundedCornerShape(30.dp),
                label = { ChipContents(tabName, imageId) },
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 20.dp),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = colorResource(id = R.color.primary_yellow),
                    selectedLabelColor = Color.White,
                    containerColor = Color.White,
                    labelColor = Color.Gray,
                ),
                border = FilterChipDefaults.filterChipBorder(
                    borderWidth = 1.dp,
                    borderColor = Color.LightGray
                )
            )
        }
    }

}

@Composable
fun ChipContents(tabName: String, imageId: Int) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Card(shape = RoundedCornerShape(100.dp),
            ) {
            Image(painter = painterResource(id = imageId),
                contentDescription = "", contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(30.dp))
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = tabName, fontSize = 13.sp)
    }
    
}


@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 10.dp), verticalAlignment = Alignment.CenterVertically) {
        Card(shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Search", fontSize = 14.sp, color = Color.Gray,
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f))
                Icon(imageVector = Icons.Default.Search, contentDescription = "",
                    tint = Color.Gray, modifier = Modifier
                        .size(32.dp)
                        .padding(horizontal = 5.dp))
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Card(shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )) {
        Icon(painter = painterResource(id = R.drawable.filter), contentDescription = "",
            tint = Color.Gray, modifier = Modifier.padding(6.dp))
        }
    }
}


@Composable
fun TopBar(modifier: Modifier = Modifier) {
    
    Row(modifier = modifier.padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically) {

        Text(text = "Pinder", fontSize = 32.sp, fontFamily = gardenC,
        color = colorResource(id = R.color.primary_yellow), fontWeight = FontWeight.ExtraBold)

        Spacer(modifier = Modifier.weight(1f))

        Column(Modifier.height(IntrinsicSize.Min), horizontalAlignment = Alignment.End) {
            Card(shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.light_purple)
            )) {
                Image(painter = painterResource(id = R.drawable.profile),
                    contentDescription = "",
                    Modifier
                        .padding(5.dp)
                        .size(30.dp))
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Outlined.LocationOn, contentDescription = "location",
                tint = colorResource(id = R.color.secondary_yellow), modifier = Modifier.size(18.dp))
                Text(text = "California", color = Color.Gray, fontSize = 10.sp)
        }
    }


    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeWindow()
}