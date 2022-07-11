//
//  NewsCellView.swift
//  SwiftUIHomework (iOS)
//
//  Created by Mikhail Kanshin on 10.04.2022.
//

import SwiftUI
import shared

struct NewsCellView: View {
    var newsInfo: NewsInfo
    
    var body: some View {
        HStack {
            VStack {
                Text(newsInfo.title)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .multilineTextAlignment(.leading)
                    .lineLimit(1)
                    .font(Font.headline.weight(.bold))
                Spacer()
                    .frame(height: 8)
                Text(newsInfo.description_)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .multilineTextAlignment(.leading)
                    .lineLimit(4)
                Spacer()
            }
            .frame(alignment: .leading)
            AsyncImage(url: URL(string: newsInfo.imageUrl ?? "")) { phase in
                switch phase {
                case .empty:
                    Color.gray.opacity(0.1)
                case .success(let image):
                    image.resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(maxWidth: 80, maxHeight: 80)
                case .failure(_):
                    EmptyView()
                @unknown default:
                    EmptyView()
                }
            }
            .frame(width: 80, height: 80)
        }
        .frame(height: 120)
    }
}

//struct NewsCellView_Previews: PreviewProvider {
//    static var previews: some View {
//        NewsCellView(newsInfo: .init()) // TODO: Add example
//    }
//}
