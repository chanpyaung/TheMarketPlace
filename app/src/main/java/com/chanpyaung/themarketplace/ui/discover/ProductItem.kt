package com.chanpyaung.themarketplace.ui.discover

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.chanpyaung.themarketplace.R
import com.chanpyaung.themarketplace.domain.models.Product

@Composable
fun ProductItem(
    product: Product,
    onItemClick: (Product) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .clickable { onItemClick(product) }
    ) {
        // Product Image
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.title,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.ic_launcher_background),
            error = painterResource(R.drawable.ic_launcher_background),
            fallback = painterResource(R.drawable.ic_launcher_background),
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Product Details
        Column(
            modifier = Modifier
                .weight(1f)
                .wrapContentHeight()
        ) {
            Text(
                text = product.location,
                color = Color.Gray,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = product.title,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                if (!product.isClassified) {
                    Column {
                        Text(
                            text = product.currentPrice,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = product.reserveState,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }


                if (product.hasBuyNow) {
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = product.buyNowPrice,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                        Text(
                            text = "Buy Now",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProductCardPreview() {
    ProductItem(
        product = Product(
            id = 1,
            title = "Title",
            location = "Auckland",
            currentPrice = "$100.00",
            buyNowPrice = "$500.00",
            hasBuyNow = true,
            isClassified = false,
            displayPrice = "$80.00",
            imageUrl = "https://example.com/image.jpg"
        ),
        onItemClick = { },
    )
}

@Preview
@Composable
fun ClassifiedProductCardPreview() {
    ProductItem(
        product = Product(
            id = 1,
            title = "Title",
            location = "Auckland",
            currentPrice = "$100.00",
            buyNowPrice = "$500.00",
            hasBuyNow = true,
            isClassified = true,
            displayPrice = "$80.00",
            imageUrl = "https://example.com/image.jpg"
        ),
        onItemClick = { }
    )
}
